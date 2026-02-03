NAME = avaj-launcher
SRC_DIR = src
SOURCES = sources.txt
PACKAGE = fr._42lyon.avaj.simulator
MAIN_CLASS = $(PACKAGE).Simulator
SCENARIO = test/scenario.txt

all: $(NAME)

$(NAME):
	find $(SRC_DIR) -name "*.java" > $(SOURCES)
	javac @$(SOURCES)

run: all
	java -cp $(SRC_DIR) $(MAIN_CLASS) $(SCENARIO)

test: all
	bash test/run_tests.sh

clean:
	find $(SRC_DIR) -name "*.class" -delete
	rm -f $(SOURCES)
	rm -f simulation.txt

re: clean all

.PHONY: all run clean re test
