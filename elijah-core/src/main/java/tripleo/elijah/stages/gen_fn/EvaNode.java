/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.hooper.GCN;

/**
 * Created 10/29/20 4:51 AM
 */
public interface EvaNode {
	String identityString();

	OS_Module module();

	void __setCoded(GNCoded aCoded);

	GCN gcn();

	//BaseEvaFunction _definedFunction();

	//DeduceTypes2 _definedModule();
}

//
//
//
