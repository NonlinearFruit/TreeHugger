# TreeHugger

TreeHugger is a variant of bf. Credit for inventing this language goes to Cluid Zhasulelm at http://esolangs.org/wiki/Treehugger. This language has 9 characters in it and formats its data as an infinite binary tree. The character set is: + - [ ] < ^ > . ,

| Character | Function |
|-----------|----------|
| + | Increment value at current node |
| - | Decrement value at current node |
| [ | if (value at current node)==0: skip past corresponding ']' |
| ] | if (value at current node)!=0: skip back to corresponding '[' |
| < | Goto left child of current node |
| ^ | Goto parent of current node |
| > | Goto right child of current node |
| . | Print value of current node to standard out as ascii |
| , | Read a character from standard in |
