package tripleo.elijah.nextgen.model;

import org.jspecify.annotations.Nullable;

public interface SM_ClassDeclaration extends SM_Node {
	@Nullable SM_ClassBody classBody();

	SM_ClassInheritance inheritance();

	SM_Name name();

	SM_ClassSubtype subType();
}
