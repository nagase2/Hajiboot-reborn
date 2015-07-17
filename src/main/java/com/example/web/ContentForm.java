package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.MstItem;

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
  private int contentId;
  private String contentName;
 // private Integer itemId;
  private Integer count;
  private String comment;
  private Integer version;
  private String createdFunction;
  private String updatedFunction;
  private MstItem mstItem;

}
