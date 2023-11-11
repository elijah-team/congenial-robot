package tripleo.elijah.stages.gen_c;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.nextgen.outputstatement.EX_Explanation;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.VariableTableEntry;
import tripleo.elijah.stages.instructions.IntegerIA;

public class ASS_IA extends WhyNotGarish_BaseFunction.ArgumentStringStatement {
	private final WhyNotGarish_BaseFunction    yf;
	private final IntegerIA                    ia;
	private final Generate_Code_For_Method.AOG aog;

	public ASS_IA(final WhyNotGarish_BaseFunction aWhyNotGarishBaseFunction, final IntegerIA aIa, final Generate_Code_For_Method.AOG aAOG) {
		yf                       = aWhyNotGarishBaseFunction;
		ia                       = aIa;
		aog                      = aAOG;
	}

	@Override
	public EX_Explanation getExplanation() {
		return EX_Explanation.withMessage("ArgumentString::integerIA");
	}

	@Override
	public String getText() {
		final GenerateC generateC = yf.getGenerateC();
		//**
		//final String    realTargetName = generateC.getRealTargetName(yf.cheat(), ia, aog);
		final @NotNull BaseEvaFunction gf            = yf.getGf();//yf.cheat();
		final VariableTableEntry       varTableEntry = yf.getVarTableEntry(ia.getIndex());
		//**
		//final String                   realTargetName = generateC.getRealTargetName(gf, varTableEntry);
		final ZoneVTE zone_vte       = yf.zoneHelper(ia);//generateC._zone.get(varTableEntry, gf);
		final String  realTargetName = zone_vte.getRealTargetName();
		//**
		//**
		final String t = Emit.emit("/*669*/") + realTargetName;
		return t;
	}
}
