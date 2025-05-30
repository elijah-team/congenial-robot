package tripleo.elijah_congenial_durable.pipelines.write;

public interface WP_Indiviual_Step {
	void act(final WritePipelineSharedState st, final WP_State_Control sc);
}
