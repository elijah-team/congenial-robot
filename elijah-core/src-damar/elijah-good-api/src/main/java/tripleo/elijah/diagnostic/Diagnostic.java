/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */

package tripleo.elijah.diagnostic;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.PrintStream;
import java.util.List;

/**
 * Created 12/26/20 5:31 AM
 */
public interface Diagnostic {
	static @NonNull Diagnostic withMessage(@NonNull String code, String string, @NonNull Severity severity) {
		return new Diagnostic() {

			@Override
			public String code() {
				return code;
			}

			@Override
			public @NonNull Locatable primary() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void report(@NonNull PrintStream stream) {
				// TODO Auto-generated method stub
				stream.printf("%s %s %n", code(), string);
			}

			@Override
			public @NonNull List<Locatable> secondary() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Severity severity() {
				return severity;
			}
		};
	}

	@Nullable String code();

	@NonNull
	Locatable primary();

	void report(PrintStream stream);

	@NonNull
	List<Locatable> secondary();

	@Nullable Severity severity();

	enum Severity {
		ERROR, INFO, LINT, WARN
	}
}

//
//
//
