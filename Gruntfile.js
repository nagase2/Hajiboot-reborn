
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
	
	// Project configuration.
	grunt.initConfig({
	  concat: {
	    options: {
	      separator: ';',
	    },
	    dist: {
	      src: ['scripts/add.js', 'scripts/add2.js'],
	      dest: 'js/concated.js',
	    },
	  },
	});
	
	grunt.loadNpmTasks('grunt-contrib-concat');
	// defaultタスクの定義
	/*grunt.registerTask('default', 'Log some stuff.', function() {
		// ログメッセージの出力
		grunt.log.write('Logging some stuff...').ok();
	});*/
	grunt.registerTask('speak', function() {
		console.log("im speaking");
	});
	grunt.registerTask('hello', function() {
		console.log("Hello, everyone.");
	});
	
	grunt.registerTask('default',['speak','hello']);
	
	
	
};