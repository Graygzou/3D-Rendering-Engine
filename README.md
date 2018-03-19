# 3D-Rendering-Engine
Basic rendering engine written in Java. This project was made during an rendering course, followed at [ENSEEIHT](http://www.enseeiht.fr/fr/index.html), a french engineer school.

# About
 We did not write the full engine but we completed it as part of an assignment. We mainly focus on transformation matrices, depth rendering, rasterization process, lighting interpolation and texture manipulation. 

# Getting started
To launch a scene, run the `src\Renderer` class. 
You have to provide a `.scene` file in first argument of the run which correspond to the scene you which to render. 
To reach the end of the rendering process, you also have to specified a `.jpg` or `.png` texture image.

All the availables scenes are in the `\data` folder. Each one of them contains a different `.off` file which correspond to a 3D mesh. Textures images are also in the `\data` folder.


# Results

## Basic Rasterization Renderer
Those pictures show 3 step of our rendering system :

1. Wireframe rendering with colored vertices.
2. Solid rendering, without lighting.
3. Solid rendering, with lighting.

#### Rabbit
<img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/rabbit1.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/rabbit2.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/rabbit3.PNG" width="30%">
<img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/rabbit1-1.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/rabbit1-2.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/rabbit1-3.PNG" width="30%">

#### Monkey
<img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/monkey1.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/monkey2.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/monkey3.PNG" width="30%">

### With texture
The following images are an example of textures rendering. We kept the previous steps but we add two more for the texture :

4. Solid rendering, with texture
5. Solid rendering, with texture combined with base color.

#### Plane with rock texture
<img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/texture1.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/texture2.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/texture3.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/texture4.PNG" width="30%"><img src="https://github.com/Graygzou/3D-Rendering-Engine/blob/master/images/texture5.PNG" width="30%">

# Contributors
* Axel Grau
* [Grégoire Boiron](https://github.com/Graygzou)
