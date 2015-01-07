module.exports = function(grunt) {

	// Project configuration.
	grunt.initConfig({

		protractor_webdriver : {
			options : {
			},
			your_target : {
			},
		},

		protractor : {
			options : {
			},
			your_target : { 
				options : {
					configFile : "protractor.conf.js", 
				}
			},
		}
	});

	grunt.loadNpmTasks('grunt-protractor-webdriver');
	grunt.loadNpmTasks('grunt-protractor-runner');

	// Default task(s).
	grunt.registerTask('default', [ 'protractor_webdriver' , 'protractor']);

};