# Bloom Filter

So what's the task? Implement a bloom filter based spell checker according to http://codekata.com/kata/kata05-bloom-filters/

## Need to know

* The bloom filter has a max limit of items of Integer.MAX_VALUE. However, for the sake of the task this suffices.
* I added two hash function. A stupid one that just return the amount of characters to ease testing. And a fast one (MURMUR3) 
which seems to be a good choice for bloom filters. However, I did not spent much time on investigating a better choice since 
this was not the task.
* You may play around with randomly generated words against a dictionary. Just go to the `PlaygroundTest`.


