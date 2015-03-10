module.exports = function(grunt) {

	// Project configuration.
	grunt.initConfig({
		karma: {
			  unit: {
			    configFile: 'myKarma.conf.js',
			    singleRun: true,
			  },
			}
	});

	grunt.loadNpmTasks('grunt-karma');

	// Default task(s).
	grunt.registerTask('tests', [ 'karma']);

};