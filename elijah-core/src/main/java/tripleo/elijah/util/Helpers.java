/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.util;

import antlr.CommonToken;
import antlr.Token;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.comp.i.ErrSink;
import tripleo.elijah.lang.i.IExpression;
import tripleo.elijah.lang.i.IdentExpression;
import tripleo.elijah.lang.i.Qualident;
import tripleo.elijah.lang.impl.DotExpressionImpl;
import tripleo.elijah.lang.impl.IdentExpressionImpl;
import tripleo.elijah.lang.impl.QualidentImpl;
import tripleo.elijjah.ElijjahTokenTypes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 9/10/20 3:44 PM
 */
public enum Helpers {
	;

	public static @NonNull String getHash(byte[] aBytes) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

//		String input;
//		md.update(input.getBytes(StandardCharsets.UTF_8));
		md.update(aBytes);

		byte[] hashBytes = md.digest();

		StringBuilder sb = new StringBuilder();
		for (byte b : hashBytes) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}

	public static @NonNull Operation<String> getHashForFilename(final @NonNull String aFilename) {
		try {
			final String hdigest = new DigestUtils(MessageDigestAlgorithms.SHA_256).digestAsHex(new File(aFilename));

			if (hdigest != null) {
				return Operation.success(hdigest);
			} else {
				return Operation.failure(new Exception("apache digest returns null"));
			}
		} catch (IOException aE) {
			return Operation.failure(aE);
		}
	}

	// TODO this method is just ugly
	@Nullable
	public static String getHashForFilenameJava(@NonNull String aFilename, @NonNull ErrSink aErrSink) throws IOException {
		final MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException aE) {
			aErrSink.exception(aE);
			return null;
		}

		final File      file = new File(aFilename);
		long            size = file.length();
		byte[]          ba   = new byte[64 * 1024];  // README Counting on reasonable sizes here
		FileInputStream bb   = null;
		try {
			bb = new FileInputStream(file);

			int n = 0, m = 0;

			while (n != -1) {
				n = bb.read(ba);
				m += n;
				md.update(ba);
			}

			assert m == size - 1;

			byte[] hashBytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (byte b : hashBytes) {
				sb.append(String.format("%02x", b));
			}

			return sb.toString();
		} finally {
			if (bb != null)
				bb.close();
		}
	}

	@NonNull
	public static <E> List<E> List_of(@NonNull final E... e1) {
		final List<E> r = new ArrayList<E>();
		Collections.addAll(r, e1);
		return r;
	}

	public static @NonNull Token makeToken(final String aText) {
		final CommonToken t = new CommonToken();
		t.setText(aText);
		return t;
	}

	public static void printXML(final Object obj, @NonNull final TabbedOutputStream tos) {
		System.err.println("** XStream support has been disabled");
/*
		final XStream x = new XStream();
		//x.setMode(XStream.ID_REFERENCES);
		x.toXML(obj, tos.getStream());
*/
	}

	public static @Nullable IExpression qualidentToDotExpression2(@NonNull final List<IdentExpression> ts) {
		return qualidentToDotExpression2(ts, 1);
	}

	public static @Nullable IExpression qualidentToDotExpression2(@NonNull final List<IdentExpression> ts, int i) {
		if (ts.size() == 1) return ts.get(0);
		if (ts.size() == 0) return null;
		IExpression r = ts.get(0);
//		int i=1;
		while (ts.size() > i) {
			final IExpression dotExpression = qualidentToDotExpression2(ts.subList(i, ts.size()), i + 1);
			i++;
			if (dotExpression == null) break;
//			r.setRight(dotExpression);
			r = new DotExpressionImpl(r, dotExpression);
		}
		return r;
	}

	public static @Nullable IExpression qualidentToDotExpression2(@NonNull final Qualident q) {
		return qualidentToDotExpression2(q.parts(), 1);
	}

	@NonNull
	public static String remove_single_quotes_from_string(final @NonNull String s) {
		return s.substring(1, s.length() - 1);
	}

	public static @NonNull String String_join(@NonNull String separator, @NonNull Iterable<String> stringIterable) {
		if (false) {
			final StringBuilder sb = new StringBuilder();

			for (final String part : stringIterable) {
				sb.append(part);
				sb.append(separator);
			}
			final String ss        = sb.toString();
			final String substring = separator.substring(0, ss.length() - separator.length());
			return substring;
		}
		// since Java 1.8
		return String.join(separator, stringIterable);
	}

	public static @NonNull Qualident string_to_qualident(@NonNull String x) {
		Qualident q = new QualidentImpl();
		for (String xx : x.split("\\.")) {
			q.append(string_to_ident(xx));
		}
		return q;
	}

	@NonNull
	public static IdentExpression string_to_ident(final String txt) {
		final CommonToken t = new CommonToken(ElijjahTokenTypes.IDENT, txt);
		return new IdentExpressionImpl(t, "<inline-absent>");
	}

	public static <T> List<String> mapCollectionElementsToString(final List<T> instructionArguments) {
		return instructionArguments.stream()
				.map(x -> x.toString())
				.collect(Collectors.toList());
	}
}

//
//
//
