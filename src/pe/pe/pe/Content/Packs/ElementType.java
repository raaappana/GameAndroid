package pe.pe.pe.Content.Packs;

public class ElementType 
{
	public static int MissingObject = -1;
	public static int MeshOptimazedForStore = 0;
	public static int MeshOptimazedForLoading = 1;
	public static int PNGTexture = 2;

	public static int MeshList = 10;
	public static int StringList = 11;
	public static int LevelObjectDescription = 12;
	public static int GameObjectDescription = 13;
	public static int RenderObjectDescription = 14;
	public static int ParticelRenderObjectDescription = 15;

	public static int CollisionMesh = 20;
	public static int ConvexMesh = 21;

	public static int Skeleton = 30;
	public static int SkeletonWithAddInfo = 31;
	public static int BaseAnimation = 40;
	public static int Character = 50;
	public static int TextureList = 60;
	public static int Material = 61;

	public static String ReturnString(int format)
	{
		if (format == MeshOptimazedForLoading)
			return "Mesh New";
		if (format == MeshOptimazedForStore)
			return "Old format (not recomendated)";
		if (format == PNGTexture)
			return "Texture (PNG)";
		if (format == Skeleton)
			return "Skeleton";
		if (format == BaseAnimation)
			return "Base Animation";
		if (format == Character)
			return "Character description";
		if (format == MeshList)
			return "Mesh List";
		if (format == SkeletonWithAddInfo)
			return "Skeleton with additional information";
		if (format == TextureList)
			return "Texture list";
		if (format == CollisionMesh)
			return "Collision mesh";
		if (format == ConvexMesh)
			return "Convex mesh";
		if (format == StringList)
			return "String list";
		if (format == LevelObjectDescription)
			return "World object description";
		if (format == GameObjectDescription)
			return "Game object description";
		if (format == RenderObjectDescription)
			return "Render object description";
		if (format == Material)
			return "Material";
		if (format == ParticelRenderObjectDescription)
			return "Particle Object Description";
		else
			return "wrong format";
	}

	public static int ReturnFormat(String format) 
	{
		if (format.compareTo("Mesh New") == 0)
			return ElementType.MeshOptimazedForLoading;
		if (format.compareTo("Old format (not recomendated)") == 0)
			return ElementType.MeshOptimazedForStore;
		if (format.compareTo("Texture (PNG)") == 0)
			return ElementType.PNGTexture;
		if (format.compareTo("Skeleton") == 0)
			return ElementType.Skeleton;
		if (format.compareTo("Base Animation") == 0)
			return ElementType.BaseAnimation;
		if (format.compareTo("Character description") == 0)
			return ElementType.Character;
		if (format.compareTo("Mesh List") == 0)
			return ElementType.MeshList;
		if (format.compareTo("Skeleton with additional information") == 0)
			return ElementType.SkeletonWithAddInfo;
		if (format.compareTo("Texture list") == 0)
			return ElementType.TextureList;
		if (format.compareTo("Collision mesh") == 0)
			return ElementType.CollisionMesh;
		if (format.compareTo("Convex mesh") == 0)
			return ElementType.ConvexMesh;
		if (format.compareTo("String list") == 0)
			return ElementType.StringList;
		if (format.compareTo("World object description") == 0)
			return ElementType.LevelObjectDescription;
		if (format.compareTo("Game object description") == 0)
			return ElementType.GameObjectDescription;
		if (format.compareTo("Render object description") == 0)
			return ElementType.RenderObjectDescription;
		if (format.compareTo("Material") == 0)
			return ElementType.Material;
		if (format.compareTo("Particle Object Description") == 0)
			return ElementType.ParticelRenderObjectDescription;
		else
			return -1;
	}
}
