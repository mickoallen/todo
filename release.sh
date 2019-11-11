#!/usr/bin/env bash
heroku container:push web -a todo
heroku container:release web -a todo