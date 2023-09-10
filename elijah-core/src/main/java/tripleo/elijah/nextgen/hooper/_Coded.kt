package tripleo.elijah.nextgen.hooper

import tripleo.elijah.stages.gen_fn.*
import tripleo.elijah.stages.gen_generic.ICodeRegistrar

internal class _Coded(private val GCN1: GCN_1) : GNCoded {
    private var code1: Int = 0

    override fun setCode(aCode: Int) {
        aCode.also { this.code1 = it }
    }
    override fun getCode(): Int {
        return this.code1
    }

    override fun getRole(): GNCoded.Role {
        when (this.GCN1.evaNode) {
            is EvaClass -> {
                return GNCoded.Role.CLASS
            }
            is EvaFunction -> {
                return GNCoded.Role.FUNCTION
            }
            is EvaNamespace -> {
                return GNCoded.Role.NAMESPACE
            }
            is EvaConstructor -> {
                return GNCoded.Role.FUNCTION // TODO??
            }
            else -> {
                throw IllegalStateException("Unexpected value: " + this.GCN1.evaNode.javaClass.name)
            }
        }
    }

    override fun register(aCr: ICodeRegistrar) {}
}
