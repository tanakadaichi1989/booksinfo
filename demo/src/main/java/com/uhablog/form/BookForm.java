package com.uhablog.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookForm {
	@NotBlank(message="タイトルを入力してください")
	private String title;
	@NotNull(message="値段を入力してください")
	@Positive(message="値段はプラスの値を入力してください")
	private Integer price;
	
}
