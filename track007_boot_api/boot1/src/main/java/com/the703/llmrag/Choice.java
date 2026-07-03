package com.the703.llmrag;

public record Choice(
	int index,
	Message message,
	String finish_reason
) {}

//@Value - import lombok.Value;
/////////////////////////////////////////////
//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) - 모든 필드를 private final로 변경
//@Getter
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode