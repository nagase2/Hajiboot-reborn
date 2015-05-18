itv = 250; // 色を変化させる間隔(ミリ秒単位)
cnt = 0;
function strFade(str) {
  c = str.charAt(cnt++);
  document.all["ID"].style.color = "#"+c+c+c+c+c+c;
  if(cnt < str.length) setTimeout("strFade('" + str + "')",itv);
  if(cnt == str.length) cnt = 0;
}
//-->