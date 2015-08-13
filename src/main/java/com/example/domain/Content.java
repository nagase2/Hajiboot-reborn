package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Generated 2015/07/07 12:06:42 by Hibernate Tools 4.3.1

/**
 * Content generated by hbm2java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Content")
@NamedQueries({@NamedQuery(name = "Content.findAll2", query = "select m from Content m")})
@NamedEntityGraphs({@NamedEntityGraph(name = "content.search",
    attributeNodes = {@NamedAttributeNode("mstItem")
    // ,@NamedAttributeNode("comments")
    }, subgraphs = {@NamedSubgraph(name = "itemTypeGraph",
        attributeNodes = {@NamedAttributeNode("mstItemType")
        })}
    )})
public class Content implements java.io.Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  private Long contentId;
  private String contentName;
  // private Integer itemId;
  private Integer count;
  private String comment;
  @Version
  private Long version;
  private String createdFunction;
  private String updatedFunction;

  private Boolean deleteFlag;
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  // UserとCustomerを多対一の関係にする。
  @JoinColumn(nullable = true, name = "item_id")
  // Joincolumnで外部キーのカラム名を指定
  private MstItem mstItem;

  // OneToManyのデータも追加してみる
  // UserCommentとか？

  // public Content(int contentId) {
  // this.contentId = contentId;
  // }

  // public Content(int contentId, Integer basketId, Integer itemTypeId,
  // Integer itemId, String comment, Float contentCount,
  // Boolean deleteFlag) {
  // this.contentId = contentId;
  // this.basketId = basketId;
  // this.itemTypeId = itemTypeId;
  // this.itemId = itemId;
  // this.comment = comment;
  // this.contentCount = contentCount;
  // this.deleteFlag = deleteFlag;
  // }

}
