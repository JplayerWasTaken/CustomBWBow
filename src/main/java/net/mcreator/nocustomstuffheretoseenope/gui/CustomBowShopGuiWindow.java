
package net.mcreator.nocustomstuffheretoseenope.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeMod;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CustomBowShopGuiWindow extends ContainerScreen<CustomBowShopGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public CustomBowShopGuiWindow(CustomBowShopGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("nocustomstuffheretoseenope:textures/custom_bow_shop.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Bow Shop", 64, 15, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 27, 65, 20, new StringTextComponent("Fire Bow"), e -> {
			NocustomstuffheretoseenopeMod.PACKET_HANDLER.sendToServer(new CustomBowShopGui.ButtonPressedMessage(0, x, y, z));
			CustomBowShopGui.handleButtonAction(entity, 0, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 27, 80, 20, new StringTextComponent("Machine Bow"), e -> {
			NocustomstuffheretoseenopeMod.PACKET_HANDLER.sendToServer(new CustomBowShopGui.ButtonPressedMessage(1, x, y, z));
			CustomBowShopGui.handleButtonAction(entity, 1, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 3, this.guiTop + 52, 85, 20, new StringTextComponent("One-Shot Bow"), e -> {
			NocustomstuffheretoseenopeMod.PACKET_HANDLER.sendToServer(new CustomBowShopGui.ButtonPressedMessage(2, x, y, z));
			CustomBowShopGui.handleButtonAction(entity, 2, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 91, this.guiTop + 51, 80, 20, new StringTextComponent("Bannanarang"), e -> {
			NocustomstuffheretoseenopeMod.PACKET_HANDLER.sendToServer(new CustomBowShopGui.ButtonPressedMessage(3, x, y, z));
			CustomBowShopGui.handleButtonAction(entity, 3, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 78, 60, 20, new StringTextComponent("TNT Bow"), e -> {
			NocustomstuffheretoseenopeMod.PACKET_HANDLER.sendToServer(new CustomBowShopGui.ButtonPressedMessage(4, x, y, z));
			CustomBowShopGui.handleButtonAction(entity, 4, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 78, 65, 20, new StringTextComponent("Bonerang"), e -> {
			NocustomstuffheretoseenopeMod.PACKET_HANDLER.sendToServer(new CustomBowShopGui.ButtonPressedMessage(5, x, y, z));
			CustomBowShopGui.handleButtonAction(entity, 5, x, y, z);
		}));
	}
}
