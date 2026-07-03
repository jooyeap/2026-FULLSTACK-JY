package com.the703.llmrag;

import java.util.List;
import lombok.Value;

public record LlmRagResponse (
		List<Choice> choices
) {}
