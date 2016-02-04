# Overview

    A model of a parser that determines the mentions, topics and URLs in
    a Twitter style message.

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

        1. The '#' denotes a topic.
        2. Characters following the '#' are a topic.
        3. A topic can include letters, numbers and underscores.
        4. However, a topic cannot have only numbers or underscores.
           It must have at least one letter and then numbers
           and underscores may follow.
        Examples:
            Valid : #onetwothree #one_2_3 #wethebest
            Invalid : #12345 #12three #_____

    URLs:

        1. A url must be less than 23 characters in length.
        2. URL mus be properly formatted, (i.e. "http://")


# Parsing

    A message is parsed using Java regex compatibility. The message
    is taken in as a string and multiple regex expressions are
    compared to the string. If the string contains any mentions,
    topics, or URLs these are added to the respective hashmaps. It
    then becomes simple to look up any values in the hashmap to
    determine whether they are in the message or not.


# Testing
    
    The message class is tested for valid message examples and then
    invalid message formats. This ensures that edge cases are
    accounted for in this set up.
