#!/bin/bash

# ====================
# 安装graphviz工具
# dotty作为图形工具对dot源文件调整

dot -T png src/hello.dot -o img/hello.png
dot -T png src/test1.dot -o img/test1.png
dot -T png src/test2.dot -o img/test2.png
dot -T png src/test4.dot -o img/test4.png
dot -T png src/test_attr_01.dot -o img/test_attr_01.png
dot -T png src/test_attr_02.dot -o img/test_attr_02.png
dot -T png src/unix_shell_01.dot -o img/unix_shell_01.png
