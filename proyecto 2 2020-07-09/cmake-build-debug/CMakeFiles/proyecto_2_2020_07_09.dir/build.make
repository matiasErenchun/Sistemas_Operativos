# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.16

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/matias/.local/share/JetBrains/Toolbox/apps/CLion/ch-0/201.7846.88/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/matias/.local/share/JetBrains/Toolbox/apps/CLion/ch-0/201.7846.88/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/proyecto_2_2020_07_09.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/proyecto_2_2020_07_09.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/proyecto_2_2020_07_09.dir/flags.make

CMakeFiles/proyecto_2_2020_07_09.dir/main.c.o: CMakeFiles/proyecto_2_2020_07_09.dir/flags.make
CMakeFiles/proyecto_2_2020_07_09.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/proyecto_2_2020_07_09.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/proyecto_2_2020_07_09.dir/main.c.o   -c "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/main.c"

CMakeFiles/proyecto_2_2020_07_09.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/proyecto_2_2020_07_09.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/main.c" > CMakeFiles/proyecto_2_2020_07_09.dir/main.c.i

CMakeFiles/proyecto_2_2020_07_09.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/proyecto_2_2020_07_09.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/main.c" -o CMakeFiles/proyecto_2_2020_07_09.dir/main.c.s

CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.o: CMakeFiles/proyecto_2_2020_07_09.dir/flags.make
CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.o: ../prueevas.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.o   -c "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/prueevas.c"

CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/prueevas.c" > CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.i

CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/prueevas.c" -o CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.s

# Object files for target proyecto_2_2020_07_09
proyecto_2_2020_07_09_OBJECTS = \
"CMakeFiles/proyecto_2_2020_07_09.dir/main.c.o" \
"CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.o"

# External object files for target proyecto_2_2020_07_09
proyecto_2_2020_07_09_EXTERNAL_OBJECTS =

proyecto_2_2020_07_09: CMakeFiles/proyecto_2_2020_07_09.dir/main.c.o
proyecto_2_2020_07_09: CMakeFiles/proyecto_2_2020_07_09.dir/prueevas.c.o
proyecto_2_2020_07_09: CMakeFiles/proyecto_2_2020_07_09.dir/build.make
proyecto_2_2020_07_09: CMakeFiles/proyecto_2_2020_07_09.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable proyecto_2_2020_07_09"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/proyecto_2_2020_07_09.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/proyecto_2_2020_07_09.dir/build: proyecto_2_2020_07_09

.PHONY : CMakeFiles/proyecto_2_2020_07_09.dir/build

CMakeFiles/proyecto_2_2020_07_09.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/proyecto_2_2020_07_09.dir/cmake_clean.cmake
.PHONY : CMakeFiles/proyecto_2_2020_07_09.dir/clean

CMakeFiles/proyecto_2_2020_07_09.dir/depend:
	cd "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09" "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09" "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug" "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug" "/home/matias/Escritorio/repo-local/Sistemas_Operativos/proyecto 2 2020-07-09/cmake-build-debug/CMakeFiles/proyecto_2_2020_07_09.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/proyecto_2_2020_07_09.dir/depend
