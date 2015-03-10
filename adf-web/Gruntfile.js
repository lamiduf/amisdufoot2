module.exports = function(grunt) {

	// Project configuration.
	grunt.initConfig({
		karma : {
			unit : {
				configFile : 'myKarma.conf.js',
				singleRun : true,
			},
		},

		protractor_webdriver : {
			options : {},
			your_target : {},
		},

		protractor : {
			options : {},
			your_target : {
				options : {
					configFile : "protractor.conf.js",
				}
			},
		}

	});

	grunt.loadNpmTasks('grunt-karma');
	grunt.loadNpmTasks('grunt-protractor-webdriver');
	grunt.loadNpmTasks('grunt-protractor-runner');

	// Default task(s).
	grunt.registerTask('tests', [ 'karma' , 'protractor_webdriver', 'protractor' ]);

};