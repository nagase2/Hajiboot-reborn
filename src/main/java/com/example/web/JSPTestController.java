package com.example.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Customer;
import com.example.domain.Food;

@Controller
@Slf4j
public class JSPTestController {
  /*
   * @ModelAttribute というアノテーションを、メソッドに付加する。このアノテーションがついたメソッドの返り値は、自動でModelに追加される。 Modelの属性名を、
   * 
   * @ModelAttribute で指定することもできるが、デフォルトでは、クラス名の先頭を小文字にした値が、属性名になる。この場合は、”echoForm
   * ”である。フォームの属性名は、次に説明する form:form タグ の modelAttribute 属性の値に一致している必要がある。
   */
  @ModelAttribute
  // (1)
  public FoodForm setUpFoodForm() {
    FoodForm form = new FoodForm();
    log.info("food Formが呼ばれました");
    return form;
  }

  @RequestMapping("/jsptest1")
  String JSPTest1(Model model, @Valid FoodForm food, BindingResult result) {
    // 受け取り
    if (result.hasErrors()) {
      log.info("errorがあります!!!!");
      return "/jsptest";
    }

    log.info("JSP test が呼ばれました。!!x!!! Food=" + food.toString());

    // 値渡しA（一つのクラスを渡すパターン）
    model.addAttribute("food", new Food(5, "aaa", "bbb"));
    model.addAttribute("result", result.hasErrors());

    return "/jsptest";
  }

  @RequestMapping("/jsptest2")
  String JSPTest2(Model model, @Valid FoodForm food, BindingResult result) {
    ArrayList<Food> foods = new ArrayList<Food>();
    foods.add(new Food(1, "111", "bbb"));
    foods.add(new Food(2, "222", "bbb"));
    foods.add(new Food(3, "333", "bbb"));
    foods.add(new Food(4, "444", "bbb"));

    Map map = new HashMap();
    map.put("football", "Honda");
    map.put("baseball", "Tanaka");
    map.put("basketball", "Tabuse");
    model.addAttribute("map", map);

    // 値渡しB(複数のクラスをListに入れて渡すパターン）
    model.addAttribute("foods", foods);
    model.addAttribute("map", map);

    log.info("JSP test2222 が呼ばれました。!!");
    return "jsptest2";
  }
}
