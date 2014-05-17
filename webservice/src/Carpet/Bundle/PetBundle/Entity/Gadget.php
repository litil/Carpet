<?php

namespace Carpet\Bundle\PetBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Gedmo\Mapping\Annotation as Gedmo;

use Doctrine\Common\Collections\ArrayCollection;

/**
 * Gadget
 *
 * @ORM\Table()
 * @ORM\HasLifecycleCallbacks()
 * @ORM\Entity(repositoryClass="Carpet\Bundle\PetBundle\Entity\GadgetRepository")
 */
class Gadget
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var datetime $created
     *
     * @Gedmo\Timestampable(on="create")
     * @ORM\Column(type="datetime")
     */
    private $created;
    
    
    /**
     * @var datetime $updated
     *
     * @Gedmo\Timestampable(on="update")
     * @ORM\Column(type="datetime")
     */
    private $updated;
    
    /**
     * @var string
     *
     * @ORM\Column(name="name", type="string", length=255)
     */
    private $name;

    /**
     *
     * @var string
     * 
     * @ORM\Column(name="slug", type="string", length=225)
     * @Gedmo\Slug(fields={"name"}, updatable=false, separator="-") 
     */
    private $slug;
    
    
    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=255)
     */
    private $type;


    /**
     * @var string
     *
     * @ORM\Column(name="description", type="blob")
     */
    private $description;

    /**
     *
     * @ORM\OneToMany(targetEntity="Possession", mappedBy="gadget")
     */
    private $possessions;

    
    public function __construct() 
    {
        $this->possessions = new ArrayCollection();
    }
    
    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set name
     *
     * @param string $name
     * @return Gadget
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string 
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Set type
     *
     * @param string $type
     * @return Gadget
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return string 
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * Set description
     *
     * @param string $description
     * @return Gadget
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string 
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Add possessions
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Possession $possessions
     * @return Gadget
     */
    public function addPossession(\Carpet\Bundle\PetBundle\Entity\Possession $possessions)
    {
        $this->possessions[] = $possessions;

        return $this;
    }

    /**
     * Remove possessions
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Possession $possessions
     */
    public function removePossession(\Carpet\Bundle\PetBundle\Entity\Possession $possessions)
    {
        $this->possessions->removeElement($possessions);
    }

    /**
     * Get possessions
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getPossessions()
    {
        return $this->possessions;
    }


    /**
     * Set slug
     *
     * @param string $slug
     * @return Gadget
     */
    public function setSlug($slug)
    {
        $this->slug = $slug;

        return $this;
    }

    /**
     * Get slug
     *
     * @return string 
     */
    public function getSlug()
    {
        return $this->slug;
    }

    /**
     * Set created
     *
     * @param \DateTime $created
     * @return Gadget
     */
    public function setCreated($created)
    {
        $this->created = $created;

        return $this;
    }

    /**
     * Get created
     *
     * @return \DateTime 
     */
    public function getCreated()
    {
        return $this->created;
    }

    /**
     * Set updated
     *
     * @param \DateTime $updated
     * @return Gadget
     */
    public function setUpdated($updated)
    {
        $this->updated = $updated;

        return $this;
    }

    /**
     * Get updated
     *
     * @return \DateTime 
     */
    public function getUpdated()
    {
        return $this->updated;
    }
    
    
    public function __toString() 
    {
        return $this->id . '-' . $this->name;
    }
}
