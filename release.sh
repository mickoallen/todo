#!/usr/bin/env bash
heroku container:push web -a todo-mo
heroku container:release web -a todo-mo