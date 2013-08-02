PluginRequest-DatedMOTD
=======================

Message Of The Day plugin that includes a date.

Simple MOTD plugin. No commands. No permissions.

This plugin displays the text in the file 'motd.txt' to every player that joins the server.

Special variables for motd.txt:
* & color codes work. & will be replaced with the color code character, \u00A7. This basically means you can use something like &1 for blue or &2 for green.
* %server will be replaced with the server's name as defined in server.properties.
* %player will be replaced with the player's username.
* %date will be replaced with the current date, in the format of MM/DD/YYYY
* %time will be replaced with the current time, in the format of HH:MM (12 hour format, not 42).
* %ampm will be replaced with either am or pm, depending on the time.
* %AMPM will be replaced with either AM or PM, depending on the time.
* %online will be replaced with a list of the currently online players (including the player who just joined), in the format of `player1, player2, player3`.