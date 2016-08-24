// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}


/*
* Option set a global username to access ssh through to remote host
* If you are going to define user from above commands then
* leave it with empty speech marks
*/
jssh.USER = "admin"


/*
* The password leave blank if you are about to use SSH Keys,
* otherwise provide password to ssh auth
*/
jssh.PASS=""


/*
* The ssh key is your id_rsa or id_dsa - please note your
* tomcat will need access/permissions to file/location
*/
//jssh.KEY="/home/youruser/.ssh/id_rsa"


/*
* If you use a key pass for your key connections then provide it below
*
/
jssh.KEYPASS=""


/*
*The ssh port to connect through if not given will default to 22
*/
jssh.PORT="22"


/*
* This is the most important configuration required for websocket calls
* in my current version the hostname is being defined by tomcat start up setenv.sh
* In my tomcat setenv.sh I have
* HOSTNAME=$(hostname)
* JAVA_OPTS="$JAVA_OPTS -DSERVERURL=$HOSTNAME"
*
* Now as per below the hostname is getting set to this value
* if not defined wschat will default it localhost:8080
*
*/
jssh.wshostname="192.168.0.101"//System.getProperty('SERVERURL')+":8080"



/*
* jssh EndPoint timeout
* by default if not defined this is set to 0
* 0 = do not disconnect on idle activity
* value can be set in milliseconds
*/
//jssh.timeout=0


/* disable.login
* Typically you should have some form of authentication mechanism
* from which you would lock down the default index pages that allows interaction
* If you do not set this to YES
* This will then disable the default index pages that allows interaction.
*/
jssh.disable.login="NO"


/*--------------------------------------------------------------------------*/
/* WEB PAGE SPECIFIC CONFIGURATION */

/*
* NEWCONNPERTRANS
* Stands for NEW CONNnection PER TRANSaction
* watch the video to understand how / what this is doing..
*/
jssh.NEWCONNPERTRANS='NO'


/* hideSessionCtrl
* this controls two buttons giving end user feature to enable new sessions per transaction or not
* set this to YES if you wish the users to see the buttons + control action via front end.
* This must be set to YES if you wish to not let end user override above defined value
*/
jssh.hideSessionCtrl="NO"


/* hideAuthBlock
* if set to YES will Hide Authentication/server block
* on the main page that loads up form to submit to remote host
* If you have configured
*/
jssh.hideAuthBlock='NO'


/* hideConsoleMenu
* Has got a little more complex from 0.10.
* If disabled it will attempt to hide all controls such as pause/resume/disconnect
* If disabled it will also check for :
* hidePauseControl + hideDiscoButton
* if those two are set to no then it will show those two buttons
*/
jssh.hideConsoleMenu="NO"


/* hideSendBlock
* this will come in handy if you wish to hide away remote execution block from end user
* set this to YES if you no longer wish end users to be able to execute remote commands
*/
jssh.hideSendBlock="NO"


/* hidePauseControl
* This hides the control buttons to pause/resume logs
*/
jssh.hidePauseControl="NO"


/* hideWhatsRunning
* This hides the label that shows what host the user is connected to and what command is being executed
*/
jssh.hideWhatsRunning="NO"


/* hideDiscoButton
* This hides the disconnect button
* unsure why you would want to - but maybe you do
*/
jssh.hideDiscoButton="NO"



/* hideNewShellButton
* This hides two buttons new shell / close shell
* as of 0.12  new shell was introduced
* its off of NSPT from earlier versions
* a cleaner way of controlling new shells/closing shells.
*/

jssh.hideNewShellButton="NO"


/* Customised ping-pong variables
*  refer to pingpong wiki page
*/
//Boolean to enable backend poll
jssh.enablePong=true
// In milliseconds
jssh.pingRate=50000


/* Security - by default off
* Enable this if you do not want anything outside of what is set in Config.groovy
* to be overridable. So if user attempts to trick and send something if sending is not allowed
* it should not allow them to do so. if a buttons action is disabled they can't override it etc.
*/
jssh.security="enabled"

// Enable this to see ping messages going through
jssh.debug="on"

jssh.disable.login="YES"
jssh.NEWCONNPERTRANS='NO'
jssh.hideSessionCtrl="YES"
jssh.hideAuthBlock='NO'
jssh.hideConsoleMenu="YES"
jssh.hideSendBlock="YES"
jssh.hidePauseControl="NO"
jssh.hideWhatsRunning="NO"
jssh.hideDiscoButton="NO"
jssh.hideNewShellButton="YES"

//Option set a global username to access ssh through to remote host
//If you are going to define user from above commands then leave it with empty speach marks
remotessh.USER = "USER"

//The password leave blank if you are about to use SSH Keys, otherwise provide password to ssh auth
remotessh.PASS=""

//The ssh key is your id_rsa or id_dsa - please note your tomcat will need access/permissions to file/location
remotessh.KEY=""

//If you use a key pass for your key connections then provide it below
remotessh.KEYPASS=""

//The ssh port to connect through if not given will default to 22
remotessh.PORT="22"