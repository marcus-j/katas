# Bloom Filter

So what's the task? Implement a bloom filter based spell checker, as defined in http://codekata.com/kata/kata05-bloom-filters/

## Need to know

* The bloom filter has a max. limit of items of Integer.MAX_VALUE. However, for the sake of the task this ought to be sufficient.
* I added two hash functions. A stupid one that just returns the amount of characters to ease testing. And a fast one (MURMUR3) 
which seems to be a good choice for bloom filters. SHA-256 and other cryptographic hash function might be to slow for this purpose.
However, I did not spent much time on investigating a better choice since this was not the task.
* You may play around with randomly generated words against a given dictionary. Just go to the `PlaygroundTest`.


