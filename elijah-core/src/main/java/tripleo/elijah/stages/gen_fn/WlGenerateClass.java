/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jdeferred2.DoneCallback;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.util.Eventual;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.nextgen.rosetta.Rosetta;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.gen_fn_r.GenerateEvaClassResponse;
import tripleo.elijah.stages.gen_fn_r.RegisterClassInvocation_env;
import tripleo.elijah.stages.gen_fn_r.GenerateEvaClassRequest;
import tripleo.elijah.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah.util.Holder;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah.work.WorkJob;
import tripleo.elijah.work.WorkManager;

/**
 * Created 5/16/21 12:41 AM
 */
public class WlGenerateClass implements WorkJob {
    private final @NotNull ClassStatement              classStatement;
    private final @NotNull ClassInvocation             classInvocation;
    private final          GenerateFunctions           generateFunctions;
    private final @NotNull RegisterClassInvocation_env __passthru_env;
    private                boolean                     _isDone       = false;
    private final          ICodeRegistrar      cr;
    //private       EvaClass       Result;
    private final          Eventual<IEvaClass> resultPromise = new Eventual<>();

    public WlGenerateClass(GenerateFunctions aGenerateFunctions,
                           @NotNull ClassInvocation aClassInvocation,
                           DeducePhase.GeneratedClasses coll,
                           final ICodeRegistrar aCodeRegistrar) {
        classStatement    = aClassInvocation.getKlass();
        generateFunctions = aGenerateFunctions;
        classInvocation   = aClassInvocation;
        if (coll != null) {
            resultPromise.then(coll::add);
        }

		cr = aCodeRegistrar;

		__passthru_env = null;
	}

    public WlGenerateClass(final GenerateFunctions aGenerateFunctions,
                           final ClassInvocation aClassInvocation,
                           final DeducePhase.GeneratedClasses coll,
                           final ICodeRegistrar aCodeRegistrar,
                           final RegisterClassInvocation_env aEnv) {
        classStatement    = aClassInvocation.getKlass();
        generateFunctions = aGenerateFunctions;
        classInvocation   = aClassInvocation;
        if (coll != null) {
            resultPromise.then(coll::add);
        }

		cr = aCodeRegistrar;

		__passthru_env = aEnv;
	}

    @Override
    public boolean isDone() {
        return _isDone;
    }

    @Override
    public void run(WorkManager aWorkManager) {
        final Eventual<IEvaClass> resolvePromise = classInvocation.resolveDeferred();

        resolvePromise.then(resultPromise::resolve); // 24/02/28 whoa

        // README 23/11/10 Could uncomment, but failure is Void, not Diagnostic
        //resolvePromise.fail(resultPromise::fail(x));

		switch (resolvePromise.state()) {
		case PENDING:
			GenerateEvaClassRequest rq = new GenerateEvaClassRequest(generateFunctions, classStatement, classInvocation, __passthru_env);
			GenerateEvaClassResponse rsp = new GenerateEvaClassResponse();
			Rosetta.GECR rosetta = Rosetta.create(rq, rsp);

			rosetta.apply();

			rsp.getEvaClassPromise().then(kl -> {
				//kl.setCode(generateFunctions.module.getCompilation().nextClassCode());

				cr.registerClass1(kl);

                    resolvePromise.resolve(kl);
                });

			break;
		case RESOLVED:
			Holder<IEvaClass> hgc = new Holder<IEvaClass>();
			resolvePromise.then(hgc::set);
			//Result = hgc.get();
			break;
		case REJECTED:
			throw new NotImplementedException();
		}
		_isDone = true;
	}

	public void resultPromise(final DoneCallback<IEvaClass> cb) {
		resultPromise.then(cb);
	}
}

//
//
//
