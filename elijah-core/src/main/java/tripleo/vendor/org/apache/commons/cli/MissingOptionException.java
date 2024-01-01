/*
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package tripleo.vendor.org.apache.commons.cli;

import org.jspecify.annotations.NonNull;

import java.util.Iterator;
import java.util.List;

/**
 * Thrown when a required option has not been provided.
 */
public class MissingOptionException extends ParseException {
	/**
	 * This exception {@code serialVersionUID}.
	 */
	private static final long serialVersionUID = 8161889051578563249L;
	/**
	 * The list of missing options and groups
	 */
	private              List missingOptions;

	/**
	 * Constructs a new {@code MissingSelectedException} with the specified list of missing options.
	 *
	 * @param missingOptions the list of missing options and groups
	 * @since 1.2
	 */
	public MissingOptionException(final @NonNull List missingOptions) {
		this(createMessage(missingOptions));
		this.missingOptions = missingOptions;
	}

	/**
	 * Construct a new {@code MissingSelectedException} with the specified detail message.
	 *
	 * @param message the detail message
	 */
	public MissingOptionException(final String message) {
		super(message);
	}

	/**
	 * Build the exception message from the specified list of options.
	 *
	 * @param missingOptions the list of missing options and groups
	 * @since 1.2
	 */
	private static @NonNull String createMessage(final @NonNull List<?> missingOptions) {
		final StringBuilder buf = new StringBuilder("Missing required option");
		buf.append(missingOptions.size() == 1 ? "" : "s");
		buf.append(": ");

		final Iterator<?> it = missingOptions.iterator();
		while (it.hasNext()) {
			buf.append(it.next());
			if (it.hasNext()) {
				buf.append(", ");
			}
		}

		return buf.toString();
	}

	/**
	 * Gets the list of options or option groups missing in the command line parsed.
	 *
	 * @return the missing options, consisting of String instances for simple options, and OptionGroup instances for
	 * required option groups.
	 * @since 1.2
	 */
	public List getMissingOptions() {
		return missingOptions;
	}
}
