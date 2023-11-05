package tripleo.elijah.nextgen.model.impl;

import tripleo.elijah.lang.i.ModuleItem;
import tripleo.elijah.nextgen.model.SM_Module;
import tripleo.elijah.nextgen.model.SM_ModuleItem;

import tripleo.elijah.nextgen.inputtree.EIT_ModuleInput;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SM_Module_ implements SM_Module {
	private final EIT_ModuleInput EITModuleInput;

	public SM_Module_(final EIT_ModuleInput aEITModuleInput) {
		EITModuleInput = aEITModuleInput;
	}

	@Override
	public @NotNull List<SM_ModuleItem> items() {
		final List<SM_ModuleItem> items = new ArrayList<>();
		for (final ModuleItem item : EITModuleInput.module().getItems()) {
			items.add(new SM_ModuleItem() {
				@Override
				public ModuleItem _carrier() {
					return item;
				}
			});
		}
		return items;
	}
}
