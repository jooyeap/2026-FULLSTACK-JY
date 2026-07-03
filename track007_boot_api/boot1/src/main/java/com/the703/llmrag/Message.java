package com.the703.llmrag;

import lombok.Value;

@Value
public class Message {
	String role;	// 역할
	String content; // 질문
}

//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) - 모든 필드를 private final로 변경
//@Getter
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode