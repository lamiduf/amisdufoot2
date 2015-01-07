exports.config = {
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['src/main/webapp/app/**/*-e2e.js'],
  multiCapabilities: [,{
      browserName: 'firefox'
  }]
  
}