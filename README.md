Elijah congenial-robot
=======================

The elijah-lang compiler.

https://github.com/elijah-team/congenial-robot

```shell
E=`mktemp -d`
git clone https://github.com/elijah-team/congenial-robot -b 2024-congenial-update $E
(cd $E && nix-shell -p maven jdk17_headless --pure --command "mvn test")
```


### 25-11-29

> "2024-congenial-actually" - This one is not as fancy, but "works"
> jdk17, mvn 3.9.9 (3.8.2?)

https://github.com/elijah-team/congenial-robot/commit/d9cfdf88498dbead4194bc4b8dafc3602535889e 

> "2024-congenial-update" - aka `gh-rolling`
> might be 21 + 3.9.9 

https://github.com/elijah-team/congenial-robot/commit/fa11439603676920ab07022733ef113ed547fa57

> "2024-congenial-03tests-try-nix"
> gh-ci determinate
> includes xtend and possibly also works (along with bad instructions)

https://github.com/elijah-team/congenial-robot/commit/049e1345c796e66527c92200418bf151b7f215991

> "w251118-001" (aka fix refaster)
> last week: some nice commits: semantic release, congenial-upper, slir, EN_Names (duh), gumtree

https://github.com/elijah-team/congenial-robot/commit/f1a57893bb15dd7865e53127e5c29de6a271c243

> "2024-congenial-03surefire-paf-remove-process-record--old-layout"
> this doesn't look valuable
> look harder
> re-added checker because $reason (aka bb.edn): 5c8269fdbba60d5198db40c7246eb4a403c112e3

https://github.com/elijah-team/congenial-robot/commit/ad2ac8164c8ca2500f658f5f1084033c9efbf5f9

> "2024-congenial-update--useless-format"
> this doesn't look valuable
> don't strain
> attempting to resolve line-based merge conflicts (by bothering humans; could/might be an interesting problem )
> wtf here: 8ffcf3838b6aa3737c7bb420e612f3e99e0f3d0d (been drinking, not drunk)

https://github.com/elijah-team/congenial-robot/commit/8ffcf3838b6aa3737c7bb420e612f3e99e0f3d0d

> "2024-congenial-03surefire-paf-remove-process-record"
> sealed interfaces have to be in the same file (0f5b132a673a15b82b15c8efa9410ffdf03ef335)
> 24-09-29 ... 25-10-24
> check this against above (also $noclue might be helpful here - something about graphs (not kit this time))

https://github.com/elijah-team/congenial-robot/commit/d50a79172337ae4df878ebb3f1069c11befd3505

> "cr-241118"
> once again, no clue
> has \[an old version of\] moshi (in pom, not code)
> 24-11-18

https://github.com/elijah-team/congenial-robot/commit/5ba68da23ac5e4097be2cc158331ef86d30f6765

> "cr-241104-002"
> 24-10-31 line
> "has asdf" (cbf6c2f2d4801f7f2f46b90d150fdcd29626fdf2) :cryinglaugh:

https://github.com/elijah-team/congenial-robot/commit/bd7e045c0b86435aa0bfd7b7912de7bea7e6cc62

> "2023-congenial-12wp-jspec"
> last commit: 24-01-01 -- This is extra (per this document)
> oh, jpecify (...)
> reformat without specification?? (81ff8f1ee2071bf3123a32783fc4af09b69cf34e)
> the point might be that there are many @annos and "caution" is necessary (f136495755ff755fb975ae34a0c6762e9c6b839e)
> notable in nothingness (81ff8f1ee2071bf3123a32783fc4af09b69cf34e)
> zero clue (712ed10be6e87f10dcf8fbd6ef507592541ee095)

https://github.com/elijah-team/congenial-robot/commit/c0aa4a877aff137c0475765e3a5057e84cc13c88

> "2023-congenial-12wp"
> just noting (esp wrt actually)
> 24-01-02

https://github.com/elijah-team/congenial-robot/commit/011ab7dfd23106e3be726a375f9c117a090841b2

> "2023-congenial-12w"
> just noting
> 24-01-03
> these two diverge from eb91d59f0148b614d6caa1be79907af5f2c9080a with some cherry-picks and then ... (you figure it out)

https://github.com/elijah-team/congenial-robot/commit/2f2f936d6d014e46699df902967f461b6be96068


### Stop here

1. Do `elevated` another day
2. Pull vigourously from `radical` line (no rush)


### Inception

- 2023 Sep 06, "New Almost" (1)
- https://github.com/elijah-team/congenial-robot/commit/edc3dd148baf319ae99590102f3fdd7371238e0c
- .. from fluffy 232cfc254a6341e9a21ff0d27a8c522f12446ac6
- .. updated b1fd0129691e933ca1876ff1c901901376dacb30
- ..
- 2023 Sep 06, {+CRT} All green. No exceptions. (2) 
- https://github.com/elijah-team/congenial-robot/commit/1a3d94afe7f9cb3f4d9bf08f53f1272694aa564e



----

Fiddle with mergify (pull #92) (branch w/240802-002)
* just giving it another shot
* no idea why i can't figure any of this out
