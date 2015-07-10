package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity
// @Table(name="customers")//テーブル名（＝クラス名）

@Data
@NoArgsConstructor
// JPAの仕様で、EntityClassには引数のないデフォルトコンストラクタを作る必要がある。
@AllArgsConstructor
public class Food {
  @Id
  // @GeneratedValue //主キーがDBで自動裁判されることをこのアノテーションで示す
  private Integer id;

  @NotNull
  // Annotation for Input check
  private String name;

  @NotNull
  // Annotation for Input check
  private String color;

}
