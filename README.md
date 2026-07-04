Elijah congenial-robot
=======================

The elijah-lang compiler.

https://github.com/elijah-team/congenial-robot

```shell
git clone https://github.com/elijah-team/congenial-robot
./mvnw test
```

This project is licensed under LGPL.

You will need JVM 17 and Maven.


GOALS
------

- Less noise
- More verification
  - got detoured on the road to correctness
  - concentrate less on EDC_*/integration and
    more on the output (viz COMP)
- More coroutines (eta tbd)


LINEAGE
--------

`Septagon` - Starting over, again

`Rosetta` - Encapsulating state/environment.  Event sourcing/Functional.

`Congenial` - Testablility/verification


TODO #3
--------

1. Be more visual
2. Be more correct
3. Be more complete
4. Be less hungry


TODO #2
--------

1. Add tools (checkstyle)
2. Separation (good-api, fluffy; source-model)
3. Verification (jquik)
4. Inference and Characterization (?? \[please don't\] and tests)


TODO #1
--------

1. Convert to ant (nts: the runConfig's; and congenial-upper,mal,etc)
2. Finish vision
3. Stop fuddling
