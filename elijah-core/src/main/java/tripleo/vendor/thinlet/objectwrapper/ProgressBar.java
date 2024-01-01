/* objectWrapperThinlet - http://perso.club-internet.fr/sjobic/thinlet/
 * Copyright (C) 2004 Norbert Barbosa (norbert.barbosa@laposte.net)
 *
 * An extension of the Thinlet GUI toolkit (http://www.thinlet.com)
 * that add wrapper object for thinlet component.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package tripleo.vendor.thinlet.objectwrapper;

import org.jspecify.annotations.NonNull;
import tripleo.vendor.thinlet.Thinlet;
import tripleo.vendor.thinlet.ThinletConstants;

/**
 * Widget that represent the thinlet progressbar.
 *
 * @author Norbert Barbosa
 * @version @owthinlet.version@
 */
public class ProgressBar extends OWWidget {

	public ProgressBar(OWThinlet thinlet, Object component) {
		super(thinlet, component);
	}

	public ProgressBar(OWThinlet thinlet) {
		super(thinlet, Thinlet.create(ThinletConstants.PROGRESSBAR));
	}

	public int getMinimum() {
		return fthinlet.getInteger(unwrap(), ThinletConstants.MINIMUM);
	}

	public void getMinimum(int value) {
		fthinlet.setInteger(unwrap(), ThinletConstants.MINIMUM, value);
	}

	public int getMaximum() {
		return fthinlet.getInteger(unwrap(), ThinletConstants.MAXIMUM);
	}

	public void getMaximum(int value) {
		fthinlet.setInteger(unwrap(), ThinletConstants.MAXIMUM, value);
	}

	public int getValue() {
		return fthinlet.getInteger(unwrap(), ThinletConstants.VALUE);
	}

	public void getValue(int value) {
		fthinlet.setInteger(unwrap(), ThinletConstants.VALUE, value);
	}

	public EnumOrientation getOrientation() {
		return EnumOrientation.fromString(fthinlet.getChoice(unwrap(), ThinletConstants.ORIENTATION));
	}

	public void setOrientation(@NotNull EnumOrientation value) {
		fthinlet.setChoice(unwrap(), ThinletConstants.ORIENTATION, value.toString());
	}
}
