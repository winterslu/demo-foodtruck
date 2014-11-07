demo-foodtruck
==============

An Food Truck Finding service demo project: sample application to explore food trucks around San Francisco downtown. Total more than 600 truck records retrived from [DataSF](http://www.datasf.org/). 

There are 3 major functions in this app:
- Random Search: will randomly select 20 food truck from database and display them on map.
- Closest Search*: will search the closest 20 food trucks according to your current location.
- Range Search*: will search all food trucks those are in 5 miles range of your current location. You can also manually change search range by drag and edit search range weiget on map. 

*If there is no geolocation on your browser/device or you deny allowing access to Geo info, will search around center of SF downtown.



http://app.winterslu.com/Foodtruck-poc/

Technologies/Stack

- Backbone
- Google Map Javascript API
- Twitter Bootstrap v3

- Jersey REST services
- Spring + Hibernate
- PostgreSQL Database

All libs/frameworks I leveraged in this project are handled by Maven/CDN, that means no codes are auto-generated. Only web boilerplate code is used [Bootstrap Cover template](http://getbootstrap.com/examples/cover/) with lots of modification in CSS and migration into Backbone templates.

Server backend is a simple CRUD web service built up with Spring+Hibernate+Jersey+Postgres. All data sets are exported from DataSF first and then imported into Postgres.

I built this app in totally 4 days by myself. Before this app, I have little experience building Backbone app(personally I prefer AngularJS even its more heavy for small project but good to maintain code and unify coding style.). My front-end experience includes more than a year works on AngularJS, d3.js, crossfilter.js as well as iOS and Android Development. I have about year experience working on backend Webservice like Apache CXF, Spring, Hibernate and relational database. 

Whole app is hosted on [DigitalOcean](https://www.digitalocean.com/) with a minimun 5$/month machine. It also hosts my personal [website/blog](http://www.winterslu.com).