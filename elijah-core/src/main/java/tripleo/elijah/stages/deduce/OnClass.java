/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import tripleo.elijah.stages.gen_fn.IEvaClass;

/**
 * Created 3/17/21 9:26 PM
 */
public interface OnClass {
	void classFound(IEvaClass aGeneratedNode);
}

//
//
//
