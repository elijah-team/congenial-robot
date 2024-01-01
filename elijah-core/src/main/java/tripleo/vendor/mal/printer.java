package tripleo.vendor.mal;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jspecify.annotations.NonNull;
import tripleo.vendor.mal.types.MalList;
import tripleo.vendor.mal.types.MalVal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class printer {

	public static @NonNull String join(final @NonNull Map<String, MalVal> value,
									   final String delim, final Boolean print_readably) {
		final ArrayList<String> strs = new ArrayList<String>();
		for (final Map.Entry<String, MalVal> entry : value.entrySet()) {
			if (entry.getKey().length() > 0 &&
					entry.getKey().charAt(0) == '\u029e') {
				strs.add(":" + entry.getKey().substring(1));
			} else if (print_readably) {
				strs.add("\"" + entry.getKey() + "\"");
			} else {
				strs.add(entry.getKey());
			}
			strs.add(entry.getValue().toString(print_readably));
		}
		return Joiner.on(" ").join(strs);
	}

	public static String _pr_str(final @NonNull MalVal mv,
								 final Boolean print_readably) {
		return mv.toString(print_readably);
	}

	public static @NonNull String _pr_str_args(final @NonNull MalList args,
											   final @NonNull String sep, final Boolean print_readably) {
		return join(args.getList(), sep, print_readably);
	}

	public static @NonNull String join(final @NonNull List<MalVal> value,
									   final @NonNull String delim, final Boolean print_readably) {
		final ArrayList<String> strs = new ArrayList<String>();
		for (final MalVal mv : value) {
			strs.add(mv.toString(print_readably));
		}
		return Joiner.on(delim).join(strs);
	}

	public static String escapeString(final String value) {
		return StringEscapeUtils.escapeJava(value);
	}
}
