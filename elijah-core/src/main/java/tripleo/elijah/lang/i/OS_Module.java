package tripleo.elijah.lang.i;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.ci.LibraryStatementPart;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.contexts.ModuleContext;
import tripleo.elijah.entrypoints.EntryPoint;
import tripleo.elijah.lang2.ElElementVisitor;

import java.util.Collection;
import java.util.List;

public interface OS_Module extends OS_Element {
	void add(ModuleItem anElement);

	@NonNull List<EntryPoint> entryPoints();

	@Nullable OS_Element findClass(String aClassName);

	void finish();

	@NonNull Compilation getCompilation();

	@Override Context getContext();

	String getFileName();

	@Override @Nullable OS_Element getParent();

	LibraryStatementPart getLsp();

	@Override void visitGen(@NonNull ElElementVisitor visit);

	boolean hasClass(String className); // OS_Container

	boolean isPrelude();

	void postConstruct();

	OS_Module prelude();

	OS_Package pullPackageName();

	OS_Package pushPackageNamed(Qualident aPackageName);

	void setContext(ModuleContext mctx);

	void setFileName(String fileName);

	void setIndexingStatement(IndexingStatement idx);

	void setLsp(@NonNull LibraryStatementPart lsp);

	void setParent(@NonNull Compilation parent);

	void setPrelude(OS_Module success);

	@Override void serializeTo(SmallWriter sw);

	@NonNull Collection<ModuleItem> getItems();
}
