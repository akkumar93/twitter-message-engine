# Overview

    A model of a parser that determines the mentions, topics and URLs in a Twitter style message.

# Twitter Syntax

    Mentions:
        1. The '@' denotes a mention.
        2. characters following the '@' are a username.
        3. Username can be no more than 15 characters in length.
        4. Can be made of only alphanumeric characters and underscores.
        Examples:
            Valid : @akshar @kumar @akshar_kumar @the123_best
            Invalid: @akshar! @ku*mar @#$%^&

    Topics:
