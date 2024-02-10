Elijah congenial-robot
=======================

The elijah-lang compiler.

[https://github.com/elijah-team/congenial-robot](https://github.com/elijah-team/congenial-robot)

```shell
E=`mktemp -d`
git clone https://github.com/elijah-team/congenial-robot -b 2024-congenial-23-12w $E
#mkdir $E/COMP
(cd $E && nix-shell -p maven jdk17 --pure --command "mvn test")
```

This project is licensed under LGPL.

You will need JVM 17 and Maven.


GOALS
------

- Less noise
- More verification
  - on the road to correctness


LINEAGE
--------

`Septagon` - Starting over, again

`Rosetta` - Encapsulating state/environment. Pull model.

`Congenial` - Testablility/verification

`Congenial 12` (5be65927f94b7bd78d13a7fbfce22c995ab1e9fd) - jumpoff for `2024-congenial-23-12w`

TODO
-----

- Convert to ant
- Finish vision
- Stop fuddling


PURPOSE
--------

Waste saturday morning


BUILD
------

```shell
mvn clean compile test
```
```shell
mvn test
```
