# htmlpublisher-util
This very simple library can be used to create a TOC (index.html) for multiple html files available on file-system. It will parse the path of each file available on file system and create an index.html which can be used to navigate to each html from there.

I have used this to tool in conjuction with HTML Publisher Plugin (https://wiki.jenkins-ci.org/display/JENKINS/HTML+Publisher+Plugin), Where i have multile html files in a folder without a TOC (index.html). I generate TOC using this tool and HTML Publisher Plug publishes them on Jenkins server.  

Use ant sample to see how it works.
