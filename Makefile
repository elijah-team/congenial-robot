all:
	-echo this needs to be a hook

clean-compile:
	git log --pretty=oneline --max-count=1 >> ./.meta/clean-compile.txt
