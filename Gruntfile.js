
/*
 module.exports = function(grunt){


 grunt.registerTask('speak',function(){
 console.log("im speaking");
 });
 grunt.registerTask('yell',function(){
 console.log("im speaking");
 });
 }
 */

module.exports = function(grunt) {
	// Gruntの設定
	grunt.initConfig({
		pkg : grunt.file.readJSON('package.json')
	});
	// defaultタスクの定義
	grunt.registerTask('default', 'Log some stuff.', function() {
		// ログメッセージの出力
		grunt.log.write('Logging some stuff...').ok();
	});
	grunt.registerTask('speak', function() {
		console.log("im speaking");
	});
	grunt.registerTask('hello', function() {
		console.log("Hello, everyone.");
	});
};