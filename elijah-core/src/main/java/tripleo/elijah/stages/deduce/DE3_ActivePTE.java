package tripleo.elijah.stages.deduce;

import org.jdeferred2.DoneCallback;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.comp.notation.GM_GenerateModule;
import tripleo.elijah.comp.notation.GM_GenerateModuleRequest;
import tripleo.elijah.comp.notation.GN_GenerateNodesIntoSink;
import tripleo.elijah.comp.notation.GN_GenerateNodesIntoSinkEnv;
import tripleo.elijah.nextgen.inputtree.EIT_ModuleList;
import tripleo.elijah.nextgen.reactive.Reactivable;
import tripleo.elijah.nextgen.reactive.ReactiveDimension;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.stages.gen_generic.pipeline_impl.DefaultGenerateResultSink;
import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah.work.WorkList;
import tripleo.elijah.work.WorkManager;
import tripleo.elijah_congenial.pipelines.DGRS_Client;

import java.util.List;
import java.util.function.Consumer;

import static tripleo.elijah.util.Helpers.List_of;

class DE3_ActivePTE implements DE3_Active {
    private final          DeduceTypes2                      deduceTypes2;
    private final @NotNull ProcTableEntry                    pte;
    private final          ClassInvocation                   ci;
    private final @NotNull List<Reactivable>                 ables;
    private final          DeduceTypes2.DeduceTypes2Injector __inj;
    private                boolean                           __do_001_called;

    public DE3_ActivePTE(final @NotNull DeduceTypes2 aDeduceTypes2,
                         final @NotNull ProcTableEntry pte,
                         final ClassInvocation classInvocation) {
        this.deduceTypes2 = aDeduceTypes2;
        this.pte          = pte;
        this.ci           = classInvocation;

        this.__inj = aDeduceTypes2._inj();

        this.ables = _inj().new_ArrayList__Ables();
    }

    private DeduceTypes2.DeduceTypes2Injector _inj() {
        return __inj;
    }

    @Override
    public void add(final Reactivable aReactivable) {
        ables.add(aReactivable);
    }

    @Override
    public <T> void addListener(final Consumer<T> t) {

    }

    @Override
    public void join(final ReactiveDimension aDimension) {
        if (aDimension instanceof DeducePhase) {
            int y = 2;
        }
        if (aDimension instanceof GenerateC generateC) {
            final ClassInvocation classInvocation = pte.getClassInvocation();
            if (classInvocation == null) {
                pte.onFunctionInvocation(x -> {
                    int y = 2;
                    assert false;
                }); // FIXME bug: points to `f'
            }

            if (classInvocation == null) {
                assert false;
            }

            classInvocation.onResolve(node -> {
                if (generateC.getResultSink() == null) {
                    final Compilation          c  = deduceTypes2.module.getCompilation();
                    final CompilationEnclosure ce = c.getCompilationEnclosure();

                    ce.getPipelineAccessPromise().then(pa -> {
                        pa.getEvaPipelinePromise().then(ep -> {
                            final DefaultGenerateResultSink grs = ep.grs(); // [T097-053]  DE3_ActivePTE
                            generateC.setResultSink(grs);
                        });
                    });
                }

                var               resultSink  = generateC.getResultSink();
                getResultEnv(generateC, resultSink, fg -> {
                    final DeducePhase deducePhase = deduceTypes2._phase();

                    __do_001(generateC, node, deducePhase, resultSink, fg);
                });
            });
        }
    }

    @NotNull
    private void getResultEnv(final @NotNull GenerateC generateC,
                              final @NotNull GenerateResultSink resultSink,
                              final @NotNull Consumer<@NotNull GenerateResultEnv> cfg) {
        final GenerateResultEnv fileGen = generateC.getFileGen();

        if (fileGen != null) {
            cfg.accept(fileGen);
            return;
        }

        // sometimes, I wonder about you
        // that being said, the below abmost certainly does not work
        assert false;

        onPipelineAccess(generateC, pa -> {
            var env = new GN_GenerateNodesIntoSinkEnv(List_of(),
                                                      new DefaultGenerateResultSink(DGRS_Client.of(pa)),
                                                      new EIT_ModuleList(List_of()),
                                                      ElLog.Verbosity.VERBOSE,
                                                      new Old_GenerateResult(),
                                                      pa,
                                                      pa.getCompilationEnclosure());
            var mod = pte.get__gf().getFD().getContext().module();
            var tt  = new GM_GenerateModuleRequest(new GN_GenerateNodesIntoSink(env), mod, env);
            var t   = new GM_GenerateModule(tt);

            var fg1 = new GenerateResultEnv(resultSink, new Old_GenerateResult(), new WorkManager(), new WorkList(), t);
            cfg.accept(fg1); // eventualregister
        });
    }

    private void onPipelineAccess(final @NotNull GenerateC generateC, final DoneCallback<IPipelineAccess> cb) {
        generateC._ce().getPipelineAccessPromise().then(cb);
    }

    //@SuppressWarnings("unused")
    private void __do_001(final @NotNull GenerateFiles generateC,
                          final EvaClass node,
                          final DeducePhase deducePhase,
                          final GenerateResultSink resultSink,
                          final GenerateResultEnv fg) {

        assert resultSink == fg.resultSink();

        if (!__do_001_called) {
            __do_001_called = true;

            final DeducePhase.GeneratedClasses classes = deducePhase.generatedClasses;

            final var classes0 = deducePhase.generatedClasses.copy();

            final int            size1 = classes.size();
            final GenerateResult x     = generateC.resultsFromNodes(List_of(node), _inj().new_WorkManager(), resultSink, fg);
            final int            size2 = classes.size();

            final var classes1 = deducePhase.generatedClasses.copy();

            if (size2 > size1) {
                logProgress(3047, "" + (size2 - size1) + " results generated for " + node.identityString());
            } else {
                logProgress(3046, "no results generated for " + node.identityString());
            }

            for (Old_GenerateResultItem result : x.results()) {
                logProgress(3045, "" + result);
            }
        }
    }

    private void logProgress(final int code, final String message) {
        System.err.println("" + code + " " + message);
    }
}
