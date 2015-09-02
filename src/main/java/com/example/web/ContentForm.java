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
  private Integer size=10;
  
  private Long contentId;
  private String contentName;
 // private Integer itemId;
  private Integer count;//数量
  private String comment;
  private Long version;
  private String createdFunction;
  private String updatedFunction;
  private MstItem mstItem;
  private boolean deleteFlag;
  //作成日時
  //作成者
  //更新日時
  //更新者
  

}
