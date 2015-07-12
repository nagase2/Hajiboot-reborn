package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * HTMLのFORMから送るデータをマッピングするクラス
 * 
 * @author nagase
 */

@Data
public class ContentForm {
  // Annotation for Input check
  @Size(min = 0, max = 127)
  private Integer page=0;
  // Annotation for Input check
  @Size(min = 0, max = 127)
  private Integer size=5;
  private String contentName;

}
