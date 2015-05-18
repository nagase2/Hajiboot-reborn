
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
	    js: {
	      src: ['scripts/add.js', 'scripts/add2.js'],
	      dest: 'js/concated1.js',
	    }, 
	    css: {
		      src: ['scripts/add.js', 'scripts/add2.js'],
		      dest: 'js/concated2.js',
		    }
	  },
	  watch: {
		  js: {
		    files: ['scripts/**/*.js'],
		    tasks: ['concat'],
		  },
		  css: {
			    files: ['css/**/*.css'],
			    tasks: ['concat'],
			  },
		},
	});
	
	grunt.loadNpmTasks('grunt-contrib-concat');
	//npm install grunt-contrib-watch --save-dev
	grunt.loadNpmTasks('grunt-contrib-watch');
	
	
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